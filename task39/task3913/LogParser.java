package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.LogRecord;

public class LogParser implements IPQuery, UserQuery {
    private Set<Record> setOfLogObjects;
    private Path logDir;

    // разбор строк в объекты Record
    private Set<Record> parseStringsToRecordObjects(List<String> listOfLogStrings){
        Set<Record> result = new HashSet<>();
        for (String recordString : listOfLogStrings) {
            String[] recordStringArray = recordString.split("\\t");
            Record record = new Record();
            // ip адрес
            record.setIpAddress(recordStringArray[0]);
            // имя пользователя
            record.setUserName(recordStringArray[1]);
            // дата
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            try {
                Date date = dateFormat.parse(recordStringArray[2]);
                record.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // event
            record.setEvent(Event.valueOf(recordStringArray[3].split("\\s")[0])) ;
            // номер задачи
            if (recordStringArray[3].split("\\s").length>1){
                record.setTaskNumber(Integer.parseInt(recordStringArray[3].split("\\s")[1]));
            }
            // status
            record.setStatus(Status.valueOf(recordStringArray[4]));
            // добавление записи в список
            result.add(record);
        }
        return result;
    }

    // конструктор
    public LogParser(Path logDir){
        this.setOfLogObjects = parseStringsToRecordObjects(readLogFiles(logDir));
    }

    // проверка, попадает ли дата в интервал
    private boolean isDateFromInterval(Date current, Date after, Date before){
        boolean result = false;
        if (after == null) after = current;
        if (before == null) before = current;
        if ((current.getTime()>=after.getTime())&&(current.getTime()<=before.getTime())) result = true;
        return result;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(record.getDate(),after,before)) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(record.getDate(),after,before)) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (user.equals(record.getUserName()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (event.equals(record.getEvent()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if ((isDateFromInterval(record.getDate(),after,before)) && (status.equals(record.getStatus()))) {
                ipSet.add(record.getIpAddress());
            }
        }
        return ipSet;
    }

    private List<String> readLogFiles(Path logDir){
        List<String> result = new ArrayList<>();
        if (Files.isDirectory(logDir)) {
            try {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir);
                for (Path file: directoryStream) {
                    if (file.getFileName().toString().endsWith(".log")) {
                        BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            result.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (!users.contains(record.getUserName())) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && !users.contains(record.getUserName())) {
                users.add(record.getUserName());
            }
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate())) {
                if (record.getUserName().equals(user)) set.add(record.getEvent());
            }

        }
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {

            if (isDateFromInterval(after, before, record.getDate()) && record.getIpAddress().equals(ip)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && record.getEvent().equals(Event.LOGIN)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && record.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && record.getEvent().equals(Event.WRITE_MESSAGE)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && record.getEvent().equals(Event.SOLVE_TASK)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate())
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() == task) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate()) && record.getEvent().equals(Event.DONE_TASK)) {
                users.add(record.getUserName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (Record record : setOfLogObjects) {
            if (isDateFromInterval(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() == task) {
                users.add(record.getUserName());
            }
        }
        return users;
    }



    public class Record { private String ipAddress; private String userName; private Date date; private Event event; private int taskNumber; private Status status;

        public int getTaskNumber() {
            return taskNumber;
        }

        public void setTaskNumber(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }
}
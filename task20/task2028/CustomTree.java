package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable,Serializable{
    static Entry<String> root = new Entry<String>("0");
    static Entry<String> root1 = new Entry<String>("0");

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren=true;
            this.availableToAddRightChildren=true;
        }
        void checkChildren() {
            if (leftChild!=null) availableToAddLeftChildren=false;
            if (rightChild!=null) availableToAddRightChildren=false;
        }
        boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }

    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        toString(root);
        System.out.println();
        System.out.println(list.size());
//        init(root1);
//        toString(root1);
        System.out.println(getParent("5"));
//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
//        list.remove("3");
//        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public boolean add(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        boolean isAdded = false;
        while (!isAdded && !queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild!=null) {
                queue.add(currentEntry.leftChild);
            } else {
                if (!isAdded && currentEntry.availableToAddLeftChildren) {
                    Entry<String> newEntry = new Entry<String>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.leftChild = newEntry;
                    isAdded = true;
                    currentEntry.checkChildren();
                }
            }
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild!=null) {
                queue.add(currentEntry.rightChild);
            } else {
                if (!isAdded && currentEntry.availableToAddRightChildren) {
                    Entry<String> newEntry = new Entry<String>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.rightChild = newEntry;
                    isAdded = true;
                    currentEntry.checkChildren();
                }
            }
        }
        return false;
    }

    public boolean remove(String s){
        return false;
    }



    public static String getParent(String s){
        Entry<String> element=getElement1(root,s);
        if (element==null) return "gggg";
        else return element.parent.elementName;
    }

    public static Entry<String> getElement1(Entry<String> tree, String s) {
        Entry<String> result=tree;
        if (tree.elementName.equals(s))
            return tree;
        if (tree.leftChild!=null )
            result=getElement1(tree.leftChild,s);
        if (tree.rightChild != null)
            result=getElement1(tree.rightChild, s);
        System.out.println(tree.elementName);
        if(s.equals(tree.elementName)) {
            System.out.println("hhhh");
            result = tree;
        }
        System.out.println(result);
        return result;
    }

    public static Entry<String> getElement(Entry<String> tree, String s) {
        Entry<String> result=null;
        if (tree.leftChild!=null && result==null) {
            if (!tree.leftChild.elementName.equals(s))
                getElement(tree.leftChild,s);
            else {
                System.out.println("ggghhhh");
                result=tree.leftChild;
            }
        }
        if (tree.rightChild != null && result==null) {
            if (!tree.rightChild.elementName.equals(s))
                getElement(tree.rightChild,s);
            else {
                System.out.println("oooohhhh");
                result = tree.rightChild;
            }
        }
        return result;
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {

        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }




    public CustomTree() {

    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Entry<String> tree) {
        int result=1;
        if (tree.rightChild!=null) {
            result+=size(tree.rightChild);
        }
        if (tree.leftChild!=null) {
            result+=size(tree.leftChild);
        }
        return result;
    }


    public static void toString(Entry<String> tree) {
        System.out.print(" "+tree.elementName);
        if (tree.leftChild!=null) {
            toString(tree.leftChild);
        }
        if (tree.rightChild!=null) {
            toString(tree.rightChild);
        }
    }
    public static void init(Entry<String> tree) {
        tree.leftChild=new Entry<>("1");
        tree.rightChild=new Entry<>("2");
        tree.leftChild.leftChild=new Entry<>("3");
        tree.leftChild.rightChild=new Entry<>("4");
        tree.rightChild.leftChild=new Entry<>("5");
        tree.rightChild.rightChild=new Entry<>("6");
    }
}

package com.johnson;

import java.util.ArrayList;
import java.util.List;

public class FlowShopScheduling {

    public static void main(String[] arg) {

        new FlowShopScheduling().start();

    }

    /**
     * T(N,0)=min{ai+T(N-{i},bi)}
     * <p>
     * T(S,t)=min{ai+T(S-{i},bi+max{t-ai,0})}
     */

    public void start() {

        int result = 0;

        List<Task> taskList = new ArrayList<>();

        taskList.add(new Task("J0", 2, 5));

        result = methodT(taskList, 0);

        System.out.println(result);

        taskList.add(new Task("J1", 4, 2));

        result = methodT(taskList, 0);

        System.out.println(result);

        taskList.add(new Task("J2", 3, 3));

        result = methodT(taskList, 0);

        System.out.println(result);

        taskList.add(new Task("J3", 6, 1));

        result = methodT(taskList, 0);

        System.out.println(result);

        taskList.add(new Task("J4", 1, 7));

        result = methodT(taskList, 0);

        System.out.println(result);

    }

    /**
     * 求列表的最小值
     *
     * @param list
     * @return
     */

    public int min(List<Integer> list) {

        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            if (min > list.get(i)) {

                min = list.get(i);

            }

        }

        return min;

    }

    /**
     * 任务i对应的T方法
     *
     * @param taskList
     * @param t
     * @param taski
     * @return
     */

    public int methodTi(List<Task> taskList, int t, Task taski) {

        List<Task> taskListNotTaski = new ArrayList<>();

        taskListNotTaski.addAll(taskList);

        taskListNotTaski.remove(taski);

        if (taskListNotTaski.size() == 0) {

            return taski.getA() + taski.getB() + max(t - taski.getA(), 0);

        }

        int result = taski.getA() + methodT(taskListNotTaski, taski.getB() + max(t - taski.getA(), 0));

        return result;

    }

    /**
     * 主方法T
     *
     * @param taskList
     * @param t
     * @return
     */

    public int methodT(List<Task> taskList, int t) {

        List<Integer> resultList = new ArrayList<>();

        for (Task task : taskList) {

            resultList.add(methodTi(taskList, t, task));

        }

        return min(resultList);

    }

    /**
     * 求两数的最大值
     *
     * @param a
     * @param b
     * @return
     */

    public int max(int a, int b) {

        return a > b == true ? a : b;

    }

}

class Task {

    private String name;

    private int a;

    private int b;

    public Task(String name, int a, int b) {

        this.name = name;

        this.a = a;

        this.b = b;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getA() {

        return a;

    }

    public void setA(int a) {

        this.a = a;

    }

    public int getB() {

        return b;

    }

    public void setB(int b) {

        this.b = b;

    }

}

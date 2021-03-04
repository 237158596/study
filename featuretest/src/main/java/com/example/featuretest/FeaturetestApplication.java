package com.example.featuretest;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FeaturetestApplication {

    static User getUser(List<User> userList) {
        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

    static Optional<User> getUser2(List<User> userList) {
        return CollectionUtils.isEmpty(userList) ? Optional.empty() : Optional.ofNullable(userList.get(0));
    }


    static String check(ClassRoom classRoom) {
        return Optional.ofNullable(classRoom)
                .map(ClassRoom::getUserList)
                .map(FeaturetestApplication::getUser)
                .map(User::getName)
                .orElse("111")
                ;
    }


    static String check2(ClassRoom classRoom) {
        return Optional.ofNullable(classRoom)
                .map(ClassRoom::getUserList)
                .flatMap(FeaturetestApplication::getUser2)
                .map(User::getName)
                .orElse("111")
                ;
    }

    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setUserList(new ArrayList<>());
        System.out.println(check(classRoom));//111
        System.out.println(check2(classRoom));//111


        List<User> userList = new ArrayList<>();
        userList.add(new User("name1"));
        classRoom.setUserList(userList);
        System.out.println(check(classRoom));//name1

        System.out.println(check2(classRoom));//name1


    }

}

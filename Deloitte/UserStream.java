package Deloitte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserStream {

    public static List<String> getNameMoreThan25(List<User> list) {
//        List<String> returnList = userList.stream().filter((user) -> user.getAge() > 25).sorted(Comparator.reverseOrder(User::getName()).map((e) -> e.getName()).collect(Collectors.toList());
        List<String> returnList = list.stream().filter(user -> user.getAge() >= 25).sorted(Comparator.comparing(User:: getName).reversed())
                .map((e) -> e.getName()).distinct().collect(Collectors.toList());
        return returnList;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User("Sharan", 23);
        User user2 = new User("Priyan", 26);
        User user3 = new User("Priyan", 25);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        System.out.println(getNameMoreThan25(list));


    }
}

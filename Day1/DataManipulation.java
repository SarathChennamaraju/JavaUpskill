package practice3;

import java.util.*;
import java.util.stream.Collectors;

class Fruit {
    String name;
    int calories;
    int price;
    String color;

    public Fruit(String name, int calories, int price, String color) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}

class News {
    int newsId;
    String postedByUser;
    String commentByUser;
    String comment;

    public News(int newsId, String postedByUser, String commentByUser, String comment) {
        this.newsId = newsId;
        this.postedByUser = postedByUser;
        this.commentByUser = commentByUser;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", postedByUser='" + postedByUser + '\'' +
                ", commentByUser='" + commentByUser + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

class Trader {
    String name;
    String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Transaction {
    Trader trader;
    int year;
    int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}

public class DataManipulation {

    public static void main(String[] args) {
        // Create sample data
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Apple", 80, 2, "Red"),
                new Fruit("Banana", 120, 1, "Yellow"),
                new Fruit("Orange", 90, 3, "Orange"),
                new Fruit("Cherry", 60, 5, "Red"),
                new Fruit("Grapes", 70, 4, "Purple")
        );

        List<News> newsList = Arrays.asList(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting article."),
                new News(3, "User1", "Commenter3", "Budget discussion."),
                new News(4, "User3", "Commenter1", "I disagree."),
                new News(5, "User2", "Commenter2", "Budget is important."),
                new News(6, "User1", "Commenter3", "Good job!")
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(new Trader("John", "Pune"), 2011, 1000),
                new Transaction(new Trader("Alice", "Mumbai"), 2012, 2000),
                new Transaction(new Trader("Bob", "Pune"), 2011, 1500),
                new Transaction(new Trader("Charlie", "Delhi"), 2012, 3000),
                new Transaction(new Trader("David", "Indore"), 2011, 1200)
        );

        // Operations

        // 1. Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories.
        List<String> lowCalorieFruits = fruits.stream()
                .filter(fruit -> fruit.calories < 100)
                .sorted(Comparator.comparingInt(fruit -> fruit.calories))
                .map(fruit -> fruit.name)
                .collect(Collectors.toList());
        System.out.println("Low calorie fruits: " + lowCalorieFruits);

        // 2. Display color-wise list of fruit names.
        Map<String, List<String>> colorWiseFruits = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.color,
                        Collectors.mapping(fruit -> fruit.name, Collectors.toList())));
        System.out.println("Color-wise fruits: " + colorWiseFruits);

        // 3. Display only RED color fruits sorted as per their price in ascending order.
        List<String> redFruits = fruits.stream()
                .filter(fruit -> "Red".equals(fruit.color))
                .sorted(Comparator.comparingInt(fruit -> fruit.price))
                .map(fruit -> fruit.name)
                .collect(Collectors.toList());
        System.out.println("Red color fruits: " + redFruits);

        // 4. Find out the newsId which has received maximum comments.
        int maxCommentsNewsId = newsList.stream()
                .max(Comparator.comparingInt(news -> news.comment.length()))
                .map(news -> news.newsId)
                .orElse(-1);
        System.out.println("NewsId with maximum comments: " + maxCommentsNewsId);

        // 5. Find out how many times the word 'budget' arrived in user comments on all news.
        long budgetCount = newsList.stream()
                .map(news -> news.comment.toLowerCase())
                .filter(comment -> comment.contains("budget"))
                .count();
        System.out.println("Occurrences of 'budget' in comments: " + budgetCount);

        // 6. Find out which user has posted maximum comments.
        String userWithMaxComments = newsList.stream()
                .collect(Collectors.groupingBy(news -> news.postedByUser, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No user found");
        System.out.println("User with maximum comments: " + userWithMaxComments);

        // 7. Display commentByUser-wise number of comments.
        Map<String, Long> commentByUserCount = newsList.stream()
                .collect(Collectors.groupingBy(news -> news.commentByUser, Collectors.counting()));
        System.out.println("CommentByUser-wise comment count: " + commentByUserCount);
}
}
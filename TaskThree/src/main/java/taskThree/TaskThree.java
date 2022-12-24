package taskThree;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TaskThree {

    public static void main(String[] args) {

        String path = "src/main/resources/file.json";
        Root root = dataFromJson(path);
        printBriefInformation(root);
        //System.out.println("-----------------");
        //printOverdueSecurities(root);
        //System.out.println("-----------------");
        //printInfoToUserRequest(root);
        //System.out.println("-----------------");
        //printSecuritiesInfo(root);

    }

    public static void printBriefInformation(Root root) {
        root.getCompanies().forEach(e -> {
            String founded = e.getFounded().replaceAll("\\.", "/");
            founded = founded.substring(0,6) + founded.substring(8);
            System.out.println(e.getName() + " - " + founded);
        });
    }

    public static Root dataFromJson(String path) {
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;
        try {
            root = mapper.readValue(new File(path), Root.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void printOverdueSecurities(Root root) {
        List<String> listOfOverdueSecurities = new ArrayList<>();
        int overdueSecuritiesCount = 0;
        String[] date = getLocalDate();
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        root.getCompanies().forEach(e -> {
            e.getSecurities().
                    forEach(security -> {
                        String overdueDate = security.getDate();
                        String[] overdueDateArray = overdueDate.split("\\.");
                        int overdueDay = Integer.parseInt(overdueDateArray[0]);
                        int overdueMonth = Integer.parseInt(overdueDateArray[1]);
                        int overdueYear = Integer.parseInt(overdueDateArray[2]);
                        if (overdueYear < year) {
                            listOfOverdueSecurities.add(security.getCode() + " " + security.getDate() + " " + security.getName());
                        } else if (overdueYear == year) {
                            if (overdueMonth < month) {
                                listOfOverdueSecurities.add(security.getCode() + " " + security.getDate() + " " + security.getName());
                            } else {
                                if (overdueDay < day) {
                                    listOfOverdueSecurities.add(security.getCode() + " " + security.getDate() + " " + security.getName());
                                }
                            }
                        }
                    });
        });
        overdueSecuritiesCount = listOfOverdueSecurities.size();
        listOfOverdueSecurities.forEach(System.out::println);
        System.out.println("Суммарное число просроченных ценных бумаг: " + overdueSecuritiesCount);
    }

    private static String[] getLocalDate() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")).split("\\.");
    }

    public static void printInfoToUserRequest(Root root) {
        List<String> listOfFounded = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите день месяца в формате дд: ");
        int userDay = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите месяц в числовом формате ММ: ");
        int userMonth = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите год: ");
        int userYear = 0;
        String userYearAsString = scanner.nextLine();
        if (userYearAsString.length() == 4) {
            userYear = Integer.parseInt(userYearAsString);
        } else if (userYearAsString.length() == 2) {
            if(Integer.parseInt(userYearAsString) <= 59) {
                userYearAsString = "20" + userYearAsString;
                userYear = Integer.parseInt(userYearAsString);
            } else {
                userYearAsString = "19" + userYearAsString;
                userYear = Integer.parseInt(userYearAsString);
            }
        }
        listOfFounded = root.getCompanies().stream().map(company -> company.getFounded()).collect(Collectors.toList());
        for (int i = 0; i < listOfFounded.size(); i++) {
            String founded = listOfFounded.get(i);
            String[] companyFoundedArray = founded.split("\\.");
            int foundedDay = Integer.parseInt(companyFoundedArray[0]);
            int foundedMonth = Integer.parseInt(companyFoundedArray[1]);
            int foundedYear = Integer.parseInt(companyFoundedArray[2]);
            if (foundedYear > userYear) {
                System.out.println(root.getCompanies()
                        .get(i).getName() + " " + root.getCompanies().get(i).getFounded());
            } else if (foundedYear == userYear) {
                if (foundedMonth > userMonth) {
                    System.out.println(root.getCompanies()
                            .get(i).getName() + " " + root.getCompanies().get(i).getFounded());
                } else {
                    if (foundedDay >= userDay) {
                        System.out.println(root.getCompanies()
                                .get(i).getName() + " " + root.getCompanies().get(i).getFounded());
                    } else System.out.println("Нет подходящих компаний");
                }
            }
        }
    }

    public static void printSecuritiesInfo(Root root) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите код валюты: 1 - EU, 2 - USD, 3 - RUB");
        int userCurrency = scanner.nextInt();
        root.getCompanies().forEach(company -> {
            company.getSecurities().forEach(security -> {
                for (int i = 0; i < security.getCurrency().size(); i++) {
                    if (userCurrency == ((security.getCurrency().get(i)).equals("EU") ?
                            1 : (security.getCurrency().get(i)).equals("USD") ?
                            2 : (security.getCurrency().get(i)).equals("RUB") ? 3 : 0)) {
                        System.out.println("id: " + company.getId() + " - " + security.getCode());
                    }
                }
            });
        });
    }

}

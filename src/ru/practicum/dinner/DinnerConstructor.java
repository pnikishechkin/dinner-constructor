package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class DinnerConstructor {

    private Hashtable<String, ArrayList<String>> dishes;

    public DinnerConstructor() {
        this.dishes = new Hashtable<>();
    }

    /**
     * Проверка на наличие типа блюда
     *
     * @param type тип блюда
     * @return true - тип блюда имеется, false - нет
     */
    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    /**
     * Проверить на наличие типа блюда и добавить, если тип новый
     *
     * @param type тип блюда
     */
    public void checkAndAddType(String type) {
        if (!checkType(type)) {
            dishes.put(type, new ArrayList<>());
        }
    }

    /**
     * Добавить новое блюдо
     *
     * @param type тип блюда
     * @param dish название блюда
     * @return результат (true - добавлено без ошибок, false - ошибка при добавлении)
     */
    public boolean addNewDish(String type, String dish) {

        checkAndAddType(type);
        dishes.get(type).add(dish);
        return true;
    }

    /**
     * Генерация комбинаций блюд
     * @param types типы блюд
     * @param countCombinations количество необходимых комбинаций
     * @return список комбинаций, каждый из которых содержащий список блюд
     */
    public ArrayList<ArrayList<String>> generateCombinations(ArrayList<String> types, int countCombinations) {

        // Базовая проверка входных значений
        if (types == null || countCombinations <= 0) {
            return null;
        }

        // Проверка на наличие каждого типа в хранилище
        for (String type : types) {
            if (!checkType(type)) {
                return null;
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Random rand = new Random();
        int index;
        ArrayList<String> combination;

        // Генерация комбинаций блюд
        for (int i = 0; i < countCombinations; i++) {
            combination = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> dish = dishes.get(type);
                index = rand.nextInt(dish.size());
                combination.add(dish.get(index));
            }
            res.add(combination);
        }

        return res;
    }

}

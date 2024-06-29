package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.MenuItem;
import com.restaurant.billingsystem.service.MenuService;

import org.springframework.stereotype.Service;
import java.util.List;

import java.util.ArrayList;

@Service
public class MenuService {
    private List<MenuItem> menuItems;

    public MenuService(){
        this.menuItems = new ArrayList<>();
    }
    //Add item
    public MenuItem addItem(MenuItem item){
        menuItems.add(item);
        return item;
    }
    //Update item
    public MenuItem updateItem(int id, MenuItem updatedItem){
        for(int i = 0; i < menuItems.size(); i++){
           if(menuItems.get(i).getId() == id){
                menuItems.set(i, updatedItem);
                return updatedItem;
           }
        }
        return null;
    }
    //Delete item
    public void deleteItem(int id){
        for(int i = 0; i < menuItems.size(); i++){
            if(menuItems.get(i).getId() == id){
                menuItems.remove(i);
            }
        }
        System.out.println("MenuItem with id " + id + " not found.");
    }
    //List all menu items
    public List<MenuItem> getAll(){
        return menuItems;
    }
    //Find specific menu item by their name
    public MenuItem getMenuItemByName(String name){
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                return menuItem;
            }
        }
        System.out.println("MenuItem with name " + name + " not found.");
        return null;
    }
    //Find specific menu item by their id
    public MenuItem getMenuItemById(int id){
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getId() == id) {
                return menuItem;
            }
        }
        System.out.println("MenuItem with id " + id + " not found.");
        return null;
    }
}
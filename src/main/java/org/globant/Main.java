package org.globant;

import org.globant.database.ConfigDB;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();
        ConfigDB.closeConnection();
    }
}
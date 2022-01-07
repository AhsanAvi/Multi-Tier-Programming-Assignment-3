/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahsan
 */

public class WorkerDAO {
    private static final String INSERT_WORKER_SQL = "insert into workers values (?, ?, ?)";
    private static final String SELECT_WHERE_SQL = "select * from workers where salary >= ? and salary <= ?";
    
    public static int addWorker(Worker worker) {
        int result = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(INSERT_WORKER_SQL); ) {
            ps.setString(1,worker.getId());
            ps.setString(2,worker.getName());
            ps.setDouble(3,worker.getSalary());
            //setting values to SQL command
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public static ArrayList<Worker> searchWorkers(double minSal, double maxSal) {
        ArrayList<Worker> workers = new ArrayList();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_WHERE_SQL);){
            ps.setDouble(1, minSal);
            ps.setDouble(2, maxSal);
            ResultSet rs = ps.executeQuery(); 
            //setting min and max to sql statement and updating

            while (rs.next()) {
                /* while there are workers within the parameters, get the id, 
                 * name and salary of each worker and add that worker to list */
                workers.add(new Worker(
                        rs.getString("id"),
                        rs.getString("fullname"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return workers;
    }
    
    public static double getAverageSalary(ArrayList<Worker> workers) {
        double averageSalary = 0;
        double scale = Math.pow(10, 2);
        for(Worker w : workers) {
            averageSalary += w.getSalary();
        }
        return Math.round(((averageSalary/workers.size()) * scale) / scale);
        //setting a rounding method to not get multiple trailing numbers
    }
    
    public static ArrayList<Worker> getTopWorker(ArrayList<Worker> workers) {
        double highestSalary = 0;
        ArrayList<Worker> topWorker = new ArrayList();
        for(Worker w : workers) {
            if (highestSalary < w.getSalary()) {
                highestSalary = w.getSalary();
                topWorker.clear();
                topWorker.add(w);
                /* getting index of current worker in for loop
                 * salary of the worker is higher than current saved salary
                 * clear the arraylist and store that worker in the arraylist */
            }
        }
        return topWorker;
    }
}

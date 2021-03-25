package com.exam5.dao;

import com.exam5.model.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {

    public Request addRequest(Request request) {
        String sql = "INSERT INTO request(name, request_date_time, birth_year, gender) values(?, now(), ?, cast(? as gender_t))";

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, request.getName());
            stmt.setInt(2, request.getBirthYear());
            stmt.setString(3, request.getGender());
            stmt.executeUpdate();
            return request;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Request> getAllRequest() {
        String sql = "SELECT * FROM request";
        List<Request> requestList = new ArrayList<>();
        try (Connection conn = new DbConnection().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getLong("id"));
                request.setRequestDateTime(rs.getDate("request_date_time"));
                request.setName(rs.getString("name"));
                request.setBirthYear(rs.getInt("birth_year"));
                request.setGender(rs.getString("gender"));
                requestList.add(request);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return requestList;
    }

    public String deleteRequestById(Long id) {
        String sql = "DELETE FROM request WHERE id = ?";

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            return "Deleted!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Error";
    }

    public List<Request> getRequestByName(String name) {
        String sql = "SELECT * FROM request WHERE name = ?";
        List<Request> requestList = new ArrayList<>();

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Request request = new Request();
                    request.setId(rs.getLong("id"));
                    request.setRequestDateTime(rs.getDate("request_date_time"));
                    request.setName(rs.getString("name"));
                    request.setBirthYear(rs.getInt("birth_year"));
                    request.setGender(rs.getString("gender"));
                    requestList.add(request);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return requestList;
    }

    public List<Request> getRequestByBirthYear(Integer birthYear) {
        String sql = "SELECT * FROM request WHERE birth_year = ?";

        List<Request> requestList = new ArrayList<>();

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, birthYear);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Request request = new Request();
                    request.setId(rs.getLong("id"));
                    request.setRequestDateTime(rs.getDate("request_date_time"));
                    request.setName(rs.getString("name"));
                    request.setBirthYear(rs.getInt("birth_year"));
                    request.setGender(rs.getString("gender"));
                    requestList.add(request);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return requestList;
    }

    public List<Request> getRequestByGender(String gender) {
        String sql = "SELECT * FROM request WHERE gender = cast(? as gender_t)";

        List<Request> requestList = new ArrayList<>();

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gender);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Request request = new Request();
                    request.setId(rs.getLong("id"));
                    request.setRequestDateTime(rs.getDate("request_date_time"));
                    request.setName(rs.getString("name"));
                    request.setBirthYear(rs.getInt("birth_year"));
                    request.setGender(rs.getString("gender"));
                    requestList.add(request);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return requestList;
    }
}

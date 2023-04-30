package com.example.minimanagermain.OtherClasses;


import java.sql.*;
import java.util.ArrayList;

/**
 * @author .py_ML_ai_MIT (Solomon Eshun)
 *This class is mainly for sending and receiving data from the database
 * */
public class DataAccess {

    /**
     * gets the id of the user that has currently logged in
     * */
    public static String getIdOfLoggedInUser;

    public static ArrayList<String> personalInfo = new ArrayList<>(4);
    public static ArrayList<String> schoolInfo = new ArrayList<>(3);
    public static ArrayList<String> aboutLearners = new ArrayList<>(5);
    public static ArrayList<String> semesterInfo = new ArrayList<>(3);

    public static boolean createUserAccount(String tId, String tName, String tClass, String pNumber,
        String email, String password, String schoolName) throws SQLException {

        boolean doesUserExist = false;

        Connection connection;
        PreparedStatement createUser;
        PreparedStatement checkUserExist;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        checkUserExist = connection.prepareStatement("""
                SELECT tId
                FROM minimanager_db.teachers_table
                WHERE tId = ?
                """);
        checkUserExist.setString(1, tId);
        resultSet = checkUserExist.executeQuery();

        if (resultSet.isBeforeFirst()){
            doesUserExist = true;
        }else {
            createUser = connection.prepareStatement("""                   
                    INSERT INTO teachers_table\s
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?)
                    """);
            createUser.setString(1, tId);
            createUser.setString(2, tName);
            createUser.setString(3, tClass);
            createUser.setString(4, pNumber);
            createUser.setString(5, email);
            createUser.setString(6, password);
            createUser.setString(7, schoolName);
            createUser.setString(8, "No location is set".toUpperCase());

            setDefaultSemesterInfo(tId, "Not set", "0000", "00/00/0000");
            createUser.executeUpdate();
        }

        return doesUserExist;
    }


    public void updateSchoolInfo(String tId, String sName, String className, String address) throws SQLException{
        Connection connection;
        PreparedStatement updateTeacherInfo;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        updateTeacherInfo = connection.prepareStatement("""
                UPDATE teachers_table
                SET schoolName = ?,\s
                	class = ?,
                    address = ?
                WHERE tId = ?
                """);
        updateTeacherInfo.setString(1, sName);
        updateTeacherInfo.setString(2, className);
        updateTeacherInfo.setString(3, address);
        updateTeacherInfo.setString(4, tId);

        updateTeacherInfo.executeUpdate();
    }

    public void updateSemInfo(String tId, String academicYear, String semester, String nextSemBegins) throws SQLException{
        Connection connection;
        PreparedStatement updateSemInfo;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        updateSemInfo = connection.prepareStatement("""
                UPDATE semester_table
                SET academic_year = ?,\s
                	semester = ?,
                    next_sem_begins = ?
                WHERE tId = ?
                """);
        updateSemInfo.setString(1, academicYear);
        updateSemInfo.setString(2, semester);
        updateSemInfo.setString(3, nextSemBegins);
        updateSemInfo.setString(4, tId);

        updateSemInfo.executeUpdate();
    }

    public void updateTeacherName(String tId, String tName) throws SQLException{
        Connection connection;
        PreparedStatement updateSemInfo;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        updateSemInfo = connection.prepareStatement("""
                UPDATE semester_table
                SET t_name = ?
                WHERE tId = ?
                """);
        updateSemInfo.setString(1, tName);
        updateSemInfo.setString(2, tId);

        updateSemInfo.executeUpdate();
    }

    public boolean changePassword(String tId, String oldPassword, String newPassword) throws SQLException{
        Connection connection;
        PreparedStatement checkPasswordExist;
        PreparedStatement updatePassword;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        checkPasswordExist = connection.prepareStatement("""
                SELECT password
                FROM teachers_table
                WHERE password = ?
                """);
        checkPasswordExist.setString(1, oldPassword);
        resultSet = checkPasswordExist.executeQuery();
        if (resultSet.isBeforeFirst()){
            return false;
        }else {
            updatePassword = connection.prepareStatement("""
                    UPDATE teachers_table
                    SET password = ?
                    WHERE tId = ?
                    """);
            updatePassword.setString(1, newPassword);
            updatePassword.setString(2, tId);
            updatePassword.executeUpdate();
            return true;
        }


    }

    public void admitStudent(String sName, String dob, String pNumber, String email, String gender,
                             String parentName, String parentNumber)throws SQLException{
        Connection connection;
        PreparedStatement checkSIdExist;
        PreparedStatement registerStudent;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        checkSIdExist = connection.prepareStatement("""
                SELECT sId
                FROM students_table
                WHERE sId = ?
                """);
        checkSIdExist.setString(1, RandomIdGenerator.accountId(1111, 9999));
        resultSet = checkSIdExist.executeQuery();
        if (resultSet.isBeforeFirst()){
            PrintValues.print("Id already exist");
        }else {
            registerStudent = connection.prepareStatement("""
                    INSERT INTO students_table
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?)
                    """);
            registerStudent.setString(1, RandomIdGenerator.accountId(1111, 9999));
            registerStudent.setString(2, sName);
            registerStudent.setString(3, dob);
            registerStudent.setString(4, pNumber);
            registerStudent.setString(5, email);
            registerStudent.setString(6, gender);
            registerStudent.setString(7, parentName);
            registerStudent.setString(8, parentNumber);

            registerStudent.executeUpdate();
        }
    }

    public static void getPersonalInfo(String id) throws SQLException{
        Connection connection;
        PreparedStatement getPersonalInfo;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        getPersonalInfo = connection.prepareStatement("""
                SELECT tId, t_name, p_number, email
                FROM teachers_table
                WHERE tId = ?
                """);

        getPersonalInfo.setString(1, id);
        resultSet = getPersonalInfo.executeQuery();
        if (resultSet.isBeforeFirst()){
            while (resultSet.next()){
                personalInfo.add(0, resultSet.getString("tId"));
                personalInfo.add(1, resultSet.getString("t_name"));
                personalInfo.add(2, resultSet.getString("p_number"));
                personalInfo.add(3, resultSet.getString("email"));
            }
        }
    }

    public static void getSemInfo(String id) throws SQLException{
        Connection connection;
        PreparedStatement getSemInfo;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        getSemInfo = connection.prepareStatement("""
                SELECT tId, semester, academic_year, next_sem_begins
                FROM semester_table
                WHERE tId = ?
                """);
        getSemInfo.setString(1, id);
        resultSet = getSemInfo.executeQuery();
        if (resultSet.isBeforeFirst()){
            while (resultSet.next()){
                semesterInfo.add(0, resultSet.getString("semester"));
                semesterInfo.add(1, resultSet.getString("academic_year"));
                semesterInfo.add(2, resultSet.getString("next_sem_begins"));
            }
        }

    }

    public static void getSchoolInfo(String id) throws SQLException{
        Connection connection;
        PreparedStatement getSchoolsInfo;
        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        getSchoolsInfo = connection.prepareStatement("""
                SELECT tId, schoolName, class, address
                FROM teachers_table
                WHERE tId = ?
                """);
        getSchoolsInfo.setString(1, id);
        resultSet = getSchoolsInfo.executeQuery();
        if (resultSet.isBeforeFirst()){
            while (resultSet.next()){
                schoolInfo.add(0, resultSet.getString("schoolName"));
                schoolInfo.add(1, resultSet.getString("class"));
                schoolInfo.add(2, resultSet.getString("address"));
            }
        }

    }

    public static void getLearnerInfo() throws SQLException{
        Connection connection;

        PreparedStatement getLearnersInfo;

        ResultSet resultSet;

        connection = DriverManager.getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);

        getLearnersInfo = connection.prepareStatement("""
                """);

    }

    public static boolean loginUser(String id, String password) throws SQLException {
        Connection connection;
        PreparedStatement checkUserExist;
        ResultSet resultSet;

        connection = DriverManager.  getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);
        checkUserExist = connection.prepareStatement("""
                SELECT password, tId
                FROM teachers_table
                WHERE password = ? AND tId = ?
                """);
        checkUserExist.setString(1, password);
        checkUserExist.setString(2, id);
        resultSet = checkUserExist.executeQuery();
        if (resultSet.isBeforeFirst()){
            while (resultSet.next()){
                String uId = resultSet.getString("tId");
                String pWord = resultSet.getString("password");

                if (uId.equals(id) && pWord.equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void setDefaultSemesterInfo(String id, String semester, String aYear, String nSemBegins) throws SQLException{
        Connection connection;
        PreparedStatement setSemesterInfo;

        connection = DriverManager.  getConnection(DBConnectionConstants.root_URL,
                DBConnectionConstants.user, DBConnectionConstants.password);
        setSemesterInfo = connection.prepareStatement("""
                INSERT INTO semester_table
                VALUES (?, ?, ?, ?)
                """);
        setSemesterInfo.setString(1, semester);
        setSemesterInfo.setString(2, aYear);
        setSemesterInfo.setString(3, nSemBegins);
        setSemesterInfo.setString(4, id);
        setSemesterInfo.executeUpdate();
    }
}

package org.vaadin.crudui.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_licence", schema = "demo")
public class UserLicence {
    private int idUser;
    private String userName;
    private String desktopNumber;
    private String userNumber;
    private String userEmail;
    private Date licenseStart;
    private Date licenseStop;
    private String teamLeader;
    private String secondTeamLeader;
    private String team;
    private String requestOpenNumber;
    private String requestCloseNumber;
    private String userConnection;
    private String homeDirectory;

    @Id
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "desktop_number", nullable = true, length = 20)
    public String getDesktopNumber() {
        return desktopNumber;
    }

    public void setDesktopNumber(String desktopNumber) {
        this.desktopNumber = desktopNumber;
    }

    @Basic
    @Column(name = "user_number", nullable = true, length = 20)
    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    @Basic
    @Column(name = "user_email", nullable = true, length = 100)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "license_start", nullable = true)
    public Date getLicenseStart() {
        return licenseStart;
    }

    public void setLicenseStart(Date licenseStart) {
        this.licenseStart = licenseStart;
    }

    @Basic
    @Column(name = "license_stop", nullable = true)
    public Date getLicenseStop() {
        return licenseStop;
    }

    public void setLicenseStop(Date licenseStop) {
        this.licenseStop = licenseStop;
    }


    @Basic
    @Column(name = "team_leader", nullable = true, length = 100)
    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    @Basic
    @Column(name = "second_team_leader", nullable = true, length = 100)
    public String getSecondTeamLeader() {
        return secondTeamLeader;
    }

    public void setSecondTeamLeader(String secondTeamLeader) {
        this.secondTeamLeader = secondTeamLeader;
    }

    @Basic
    @Column(name = "team", nullable = true, length = 50)
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Basic
    @Column(name = "request_open_number", nullable = true, length = 20)
    public String getRequestOpenNumber() {
        return requestOpenNumber;
    }

    public void setRequestOpenNumber(String requestOpenNumber) {
        this.requestOpenNumber = requestOpenNumber;
    }

    @Basic
    @Column(name = "request_close_number", nullable = true, length = 20)
    public String getRequestCloseNumber() {
        return requestCloseNumber;
    }

    public void setRequestCloseNumber(String requestCloseNumber) {
        this.requestCloseNumber = requestCloseNumber;
    }

    @Basic
    @Column(name = "user_connection", nullable = true, length = 100)
    public String getUserConnection() {
        return userConnection;
    }

    public void setUserConnection(String userConnection) {
        this.userConnection = userConnection;
    }

    @Basic
    @Column(name = "home_directory", nullable = true, length = 100)
    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLicence that = (UserLicence) o;
        return idUser == that.idUser &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(desktopNumber, that.desktopNumber) &&
                Objects.equals(userNumber, that.userNumber) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(licenseStart, that.licenseStart) &&
                Objects.equals(licenseStop, that.licenseStop) &&
                Objects.equals(teamLeader, that.teamLeader) &&
                Objects.equals(secondTeamLeader, that.secondTeamLeader) &&
                Objects.equals(team, that.team) &&
                Objects.equals(requestOpenNumber, that.requestOpenNumber) &&
                Objects.equals(requestCloseNumber, that.requestCloseNumber) &&
                Objects.equals(userConnection, that.userConnection) &&
                Objects.equals(homeDirectory, that.homeDirectory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, userName, desktopNumber, userNumber, userEmail, licenseStart,licenseStop, teamLeader, secondTeamLeader, team, requestOpenNumber, requestCloseNumber, userConnection, homeDirectory);
    }
}

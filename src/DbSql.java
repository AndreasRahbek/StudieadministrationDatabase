import java.sql.*;

public class DbSql {
    private Connection connection;
    private Statement statement;
    private Statement statement1;


    DbSql() {
        connection = null;
        statement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studieadministration";
            connection = DriverManager.getConnection(url,"root","");

        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Studerende studerendeOplysninger(int stdnr) {
        Studerende studerende = new Studerende();
        studerende.setStdnr(stdnr);
        try {
            String sql = "select * from studerende where stdnr='" + String.valueOf(stdnr) + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                studerende.setFnavn(rs.getString("fnavn"));
                studerende.setEnavn(rs.getString("enavn"));
                studerende.setAdresse(rs.getString("adr"));
                studerende.setPostnr(rs.getString("postnr"));
                studerende.setMobil(rs.getString("mobil"));
                studerende.setKlasse(rs.getString(("klasse")));
            }
            sql = "SELECT * from studfag inner join studerende on studfag.stdnr=studerende.stdnr inner join Fag on studfag.fagnr=Fag.fagnr";
            sql += " Where studfag.stdnr ='" + String.valueOf(stdnr) + "'";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Fag fag = new Fag();
                fag.setFagnr(rs.getInt("fagnr"));
                fag.setFagnavn(rs.getString("fagnavn"));
                studerende.tilmeldFag(fag);


            }
            statement.close();


            return studerende;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void opretStuderende(int stdnr, String forNavn, String efterNavn, String studentAdresse, String byPostNr, String mobilNr, String klasseNr) {
        try {
            String sql = "insert into Studerende(stdnr,fnavn,enavn,adr,postnr,mobil,klasse) values(" + "'" + stdnr + "','" + forNavn+ "','" + efterNavn + "','" + studentAdresse + "','" + byPostNr + "','" + mobilNr + "','" + klasseNr + "');";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void opretFag(int fagId,String fagNavn) {
        try {
            String sql = "insert into fag(fagnr,fagnavn) values(" + "'" + fagId + "','" + fagNavn + "');";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void tildmeldStuderendeFag(int id, int stdnr, int fagid, int karakter) {
        try {
            String sql = "insert into studfag(id,stdnr,fagnr,kar) values(" + "'" + id + "','" + stdnr + "','" + fagid + "','" + id + "');";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void frameldStuderendeFag(int stdnr, int fagid) {
        try {
            String sql = "DELETE from StuderendeFag where studfag.stdnr =" + stdnr + " and studfag.fagid =" + fagid + ";";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void alleStuderende(){
        try {
            String sql = "select * from studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("stdnr"));
                System.out.print(": ");
                System.out.print(rs.getString("fnavn"));
                System.out.print(" ");
                System.out.print(rs.getString("enavn"));
                System.out.print(", ");
                System.out.print(rs.getString("adr"));
                System.out.print(", ");
                System.out.print(rs.getString("postnr"));
                System.out.print(", ");
                System.out.print(rs.getString("mobil"));
                System.out.print(", ");
                System.out.print(rs.getString("klasse"));
                System.out.println();
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void alleFag(){
        try {
            String sql = "select * from Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("fagnr"));
                System.out.print(": ");
                System.out.print(rs.getString("fagnavn"));
                System.out.println();

            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

public class UseCase {

    DbSql db = new DbSql();

    public Studerende soegStuderende(int stdnr){
        return db.studerendeOplysninger(stdnr);

    }
}

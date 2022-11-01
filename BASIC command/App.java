public class App {
    public static void main(String[] args) throws Exception {
        Renumber renum = new Renumber();
        renum.loadProgram("Prog1.bas");
        renum.renumPrograma();
        renum.impPrograma();

        renum.writePrograma("Prog1-rn.bas");
    }
}

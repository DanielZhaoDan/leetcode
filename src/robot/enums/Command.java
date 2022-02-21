package robot.enums;


public enum Command {

    L("L", "Left"),
    R("R", "Right"),
    M("M", "Moving forward"),
    QUES("?","instruction"),
    Q("Q","quit"),
    ;

    // name of Command
    private String name;

    //description of Command
    private String description;

    private Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get pre-defined command by name
     *
     * @param name user input
     * @return Command or Null if not found
     */
    public static Command getByName(String name) {
        for(Command c : Command.values()) {
            if (name.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }
}

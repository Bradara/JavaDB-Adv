package p5_border_control;

public class Robot implements Citizen{
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }


    @Override
    public String getBirthday() {
        return "";
    }
}

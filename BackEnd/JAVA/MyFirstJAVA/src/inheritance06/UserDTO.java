package inheritance06;

// data transfer object
// id, password, name으로 구성되어 있음
public class UserDTO {
    private String id;
    private String passward;
    private String name;
    private int index;

    public UserDTO(String id, String passward, String name, int index) {
        this.id = id;
        this.passward = passward;
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

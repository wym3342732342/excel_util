package club.maddm.util.excel.domain;

/**
 * @author King
 * @version 1.0
 * @date 2020/4/16 14:49
 */
public class TestObj {
    private String name;
    private Integer age;
    private String clasz;

    public TestObj() {
    }

    public TestObj(String name, Integer age, String clasz) {
        this.name = name;
        this.age = age;
        this.clasz = clasz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClasz() {
        return clasz;
    }

    public void setClasz(String clasz) {
        this.clasz = clasz;
    }
}

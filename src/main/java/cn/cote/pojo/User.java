package cn.cote.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name = "user") //映射的表名称
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    @JsonIgnore
    private String password;

/*
    @JsonIgnore 实现忽略该字符串
    @JsonFormat(pattern="yyy-MM-dd hh:mm:ss a",locale="zh",timezone="GMT+8") 将data型数据转化为日期格式
    @JsonInclude(Include.NON_NULL) 实现当字符串为Null时选择不输出，当字符串有值时输出
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

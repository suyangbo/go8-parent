package com.go8.admin.goods.vo;

public class CatalogVO {
    private Long id;

    private String name;

    private String code;

    private Long pid;

    private Boolean parent;

    private Integer order1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Boolean getParent() {
        return parent;
    }

    public void setParent(Boolean parent) {
        this.parent = parent;
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }
}

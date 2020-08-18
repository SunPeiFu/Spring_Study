package com.sunpeifu.template.strategy;

public enum TypeEnum {
    TIAN_JING(0,"TianJin","天津"),
    SHANG_HAI(1,"ShangHai","上海"),
    BEI_JING(2,"BeiJing","北京");
    private String name;
    private int code;
    private String msg;
    TypeEnum(int code,String name,String msg) {
        this.code =code;
        this.name = name;
        this.msg = msg;
    }
    public  String getName(){
        return name;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public static TypeEnum getByName(String name){

        for (TypeEnum typeEnum : values()) {
            if (typeEnum.getName().equals(name)){
                return typeEnum;
            }
        }
     return null;
    }
}

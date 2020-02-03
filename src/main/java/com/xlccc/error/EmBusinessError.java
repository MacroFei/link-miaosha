package com.xlccc.error;

/**
 * @author Link.p
 * @date 2020/2/4 0:22
 */
public enum EmBusinessError implements CommonError {
    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),

    //10000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_LOOGIN_FAIL(20002, "用户手机号或密码不正确"),
    USER_NOT_LOGIN(20003, "用户还未登陆");


    private EmBusinessError(int errCode , String errMsg){
        this.errCode = errCode ;
        this.errMsg = errMsg;
    }
    private int errCode;
    private String errMsg ;

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg= errMsg;
        return this;
    }


}

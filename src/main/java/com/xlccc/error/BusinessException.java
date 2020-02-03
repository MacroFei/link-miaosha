package com.xlccc.error;

/**
 * @author Link.p
 * @date 2020/2/4 0:40
 * TODO 包装器模式实现BusinessException
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError ;

    public BusinessException(CommonError commonError ){
        super();
        this.commonError = commonError;
    }
    public BusinessException(CommonError commonError ,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }
    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}

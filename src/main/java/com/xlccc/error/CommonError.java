package com.xlccc.error;

/**
 * @author Link.p
 * @date 2020/2/4 0:20
 */
public interface CommonError {
    public int getErrCode();

    public String getErrMsg ();

    public CommonError setErrMsg(String errMsg);
}

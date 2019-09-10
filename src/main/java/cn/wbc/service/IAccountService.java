package cn.wbc.service;

import cn.wbc.domain.Account;

import java.util.List;

/**
 * 账户业务层的接口
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @param accountId
      */
    Account findAccountById(Integer accountId);

    /**
     * 保存用户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);


    /**
     * 删除用户
     * @param accountId
     */
    void deleteAccount(Integer accountId);


}

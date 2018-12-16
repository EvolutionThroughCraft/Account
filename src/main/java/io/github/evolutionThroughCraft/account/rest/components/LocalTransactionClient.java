/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest.components;

import io.github.evolutionThroughCraft.common.service.main.clients.TransactionClient;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class LocalTransactionClient extends TransactionClient {
    /*
    So if you try to add @Component to the transactionClient and inject it,
    it doesn't work.  (can't find the bean)

    That said, it works when I extend the class here and add @Component.
    ...this suggests that there is a "package-scan" thing going on,
    but it isn't obvious to me where this line is
    */
}

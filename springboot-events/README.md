# springboot-events

Anotaciones utilizadas:

<table><tbody><tr><td>@EventListener</td><td>&nbsp;</td></tr><tr><td>@Async</td><td>&nbsp;</td></tr><tr><td>@EnableAsync</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table>

otros temas:  
_@TransactionalEventListener_

*   AFTER\_COMMIT es la opción por defecto. Se invoca una vez el commit ha finalizado de forma exitosa.
*   AFTER\_COMPLETION se invoca cuando la transacción se ha completado.
*   AFTER\_ROLLBACK se invoca solo si la transacción ha terminado en un roll back.
*   BEFORE\_COMMIT se invoca antes de que la transacción haga el commit.

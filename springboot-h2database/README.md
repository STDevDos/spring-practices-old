# springboot-h2database
H2 Database (JDBCTemplate) + POST/GET/PATCH/PUT/DELETE

Utilizando una base de datos en memoria, esto quiere decir que,
los datos solo vivirán durante la ejecución de nuestra aplicacion y,
cuando esta termine se perderán.

Con el fin de realizar un ejemplo básico desde el @RestController realizaremos 
la petición jdbc para probar los diferentes @RequestMappaing: 


    @PostMapping     para crear un recurso en el servidor.
    @GetMapping      para obtener un recurso.
    @PatchMapping    para actualizar parcialmente un recurso.
    @PutMapping      para cambiar el estado de un recurso o actualizarlo de forma completa.
    @DeleteMapping   para eliminar un recurso.

       
https://documenter.getpostman.com/view/258022/SW7Z595H

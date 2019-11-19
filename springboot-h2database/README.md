# springboot-h2database
Simple H2 Database example

Utilizando una base de datos en memoria, esto quiere decir que,
los datos solo vivirán durante la ejecución de nuestra aplicacion y,
cuando esta termine se perderán.

Con el fin de realizar un ejemplo básico desde el @RestController realizaremos 
la peticion jdbc para probar los diferentes @RequestMappaing: 


    @PostMapping     para crear un recurso en el servidor.
    @GetMapping      para obtener un recurso.
    @PatchMapping    para actualizar parcialmente un recurso.
    @PutMapping      para cambiar el estado de un recurso o actualizarlo de forma completa.
    @DeleteMapping   para eliminar un recurso.

       

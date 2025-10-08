# ejercicios de la clase numero 2 de la corte 4 List, Set y sus implementaciones 

## ejercicio 1: gestionando una lista de tareas

Narrativa: Ana, una manager de proyectos, usa una aplicación para organizar su día. Al empezar, su lista está vacía. Añade sus 
tareas principales. Luego, revisa cuántas tiene y consulta la segunda tarea para prepararse. Se da cuenta de que una tarea es más 
urgente, así que la actualiza. Más tarde, completa la primera tarea y la elimina de la lista. Al final del día, recorre las tareas 
restantes para planificar el mañana. 


  ## ejercicio 2: Administrando una Línea de Producción de Pan

Narrativa: En una panadería, los panaderos usan un sistema para gestionar la cola del horno. Las masas normales se añaden al final 
de la línea. Cuando un horno se libera, se toma la primera masa de la cola. De repente, llega un pedido urgente de pan de centeno, 
que se "salta la fila" y se añade al principio. El jefe de panaderos echa un vistazo a la primera y última masa para coordinar 
tiempos. Finalmente, una masa se quema y debe ser retirada específicamente de la cola, sin importar su posición



 ## ejercicio 3:  Controlando el Acceso a un Área VIP
 
Narrativa: En un evento, un guardia de seguridad usa una app para validar la entrada a la zona VIP. Al inicio, carga los IDs de 
todos los invitados en el sistema. Cuando llega un invitado, la app verifica instantáneamente si su ID está en la lista. Si es así, 
se le da acceso. Un invitado se retira del evento y su ID es removido para control de aforo. Alguien intenta entrar con un ID ya 
escaneado, pero el sistema lo previene automáticamente. Al final, el guardia limpia la lista para el siguiente evento.


 ## ejercicio 4: Registrando los Pasos de un Tutorial

Narrativa: Una nueva app registra los pasos que un usuario completa durante su tutorial de bienvenida. El sistema necesita saber qué pasos únicos ha completado y mostrárselos en el orden exacto en que los hizo por primera vez. El usuario primero crea su perfil, luego sube una foto. Después, edita su perfil de nuevo, pero el sistema no debe registrar esto como un nuevo paso. Al final, se le muestra al usuario un resumen ordenado de su progreso.


  ## ejercicio 5: Organizando un Concurso de Fotografía por Puntuación

  Narrativa: Una plataforma de fotografía gestiona las entradas a un concurso. Cada foto enviada tiene una puntuación. El sistema usa un TreeSet para mantener las fotos siempre ordenadas por puntuación. La app necesita mostrar rápidamente la foto con menor y mayor puntaje. También debe poder generar listas de "finalistas" (fotos con más de 90 puntos) y "menciones honoríficas" (fotos con menos de 70). Finalmente, se anuncia a los ganadores, listándolos de mayor a menor puntuación
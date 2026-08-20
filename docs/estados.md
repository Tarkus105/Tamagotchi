
Otros estados: Sueño, Enfermedad(?)

Hay que estudiar bien qué hace cada estado, porque si son todos iguales
no tiene sentido que que haya una clase por estado. En ese caso, habrá una clase
no abstracta Estado y distintas instancias por tipo de estado, por ejemplo:

    Estado saciedad = new Estado(saciedadInicial);
    Estado diversion = new Estado(diversionInicial);
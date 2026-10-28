# 📚 TP7 - Biblioteca

¡Bienvenidos al repositorio del Trabajo Práctico 7! 
Este documento contiene los pasos necesarios para que todos podamos trabajar en equipo de forma ordenada, utilizando Git Bash y evitando conflictos en el código.

---

## 🚀 Guía de inicio rápido

### 1. Clonar el repositorio
Para empezar a trabajar, primero debes descargar el proyecto a tu computadora. Abre **Git Bash** en la carpeta donde quieras guardar el proyecto y ejecuta:

```bash
git clone https://github.com/SapioLucianoA/TP7-Biblioteca.git
cd TP7-Biblioteca
```

### 2. Crear tu propia rama (Branch)
**Regla de oro:** Nunca trabajamos directamente sobre la rama `main`. 
Para hacer tus cambios, crea una nueva rama con tu nombre o la funcionalidad que vas a programar:

```bash
# Crear y moverse a la nueva rama
git checkout -b nombre-de-tu-rama

# Ejemplo: git checkout -b feature-interfaz
```

### 3. Guardar tus cambios (Commit)
A medida que vayas avanzando con tu código, guarda los cambios en tu rama local:

```bash
# Preparar todos los archivos modificados
git add .

# Crear el commit con un mensaje descriptivo
git commit -m "Agrego la clase Libro y sus métodos"
```

---

## ⚠️ ¡IMPORTANTE! Antes de subir tus cambios

Para evitar conflictos y dolores de cabeza, **siempre** debes traer las últimas actualizaciones que los demás hayan subido a `main` antes de mandar tu código. 

Sigue estos pasos estrictamente antes de hacer un "Push":

### Paso A: Actualizar tu rama con lo último de main
Asegúrate de estar posicionado en tu rama (`git branch` para verificar) y ejecuta este comando para traer lo nuevo y fusionarlo con tu trabajo:

```bash
git pull origin main
```
> **Nota:** Si al hacer esto aparece un conflicto, Git te avisará. Deberás abrir tu editor de código, resolver el conflicto manualmente, guardar los archivos y luego hacer un `git add .` y `git commit -m "Resuelvo conflictos"`.

### Paso B: Subir tu rama a GitHub (Push)
Una vez que tu rama está actualizada con `main` y sin conflictos, ya puedes subirla al repositorio:

```bash
git push origin nombre-de-tu-rama
```

### Paso C: Crear el Pull Request (PR)
1. Ve a la página del repositorio en GitHub: [TP7-Biblioteca](https://github.com/SapioLucianoA/TP7-Biblioteca)
2. Verás un botón verde que dice **"Compare & pull request"**. ¡Haz clic ahí!
3. Deja un breve comentario de lo que hiciste y crea el PR para que el equipo pueda revisar y unir tu código al proyecto principal.

---
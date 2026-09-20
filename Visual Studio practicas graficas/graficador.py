import numpy as np
import matplotlib.pyplot as plt

# Configuración de estilo
plt.style.use('seaborn-v0_8-whitegrid')
plt.rcParams['font.size'] = 10

# 1. Sucesión convergente a_n = (5n+1)/n
n_vals = np.arange(1, 21)
a_n = (5*n_vals + 1) / n_vals
plt.figure(figsize=(6,4))
plt.plot(n_vals, a_n, 'o-', color='blue', label=r'$a_n = \frac{5n+1}{n}$')
plt.axhline(y=5, color='red', linestyle='--', label='Límite = 5')
plt.xlabel('n')
plt.ylabel('a_n')
plt.title('Sucesión convergente a 5')
plt.legend()
plt.grid(True)
plt.show()

# 2. Límite con factorización (hueco removible) f(x) = (x^2-4)/(x-2)
x = np.linspace(0, 4, 200)
y = (x**2 - 4) / (x - 2)
plt.figure(figsize=(6,4))
plt.plot(x, y, 'b-', linewidth=2, label=r'$f(x)=\frac{x^2-4}{x-2}$')
# Marcar el hueco en (2,4)
plt.plot(2, 4, 'wo', markeredgecolor='red', markersize=10, label='Hueco (2,4)')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Discontinuidad removible: límite = 4')
plt.legend()
plt.grid(True)
plt.show()

# 3. Asíntota vertical f(x) = 1/(x-3)^2
x3 = np.linspace(0, 6, 500)
y3 = 1 / (x3 - 3)**2
plt.figure(figsize=(6,4))
plt.plot(x3, y3, 'g-', linewidth=2, label=r'$f(x)=\frac{1}{(x-3)^2}$')
plt.axvline(x=3, color='red', linestyle='--', label='Asíntota vertical x=3')
plt.ylim(0, 10)  # Limitar para ver la asíntota
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Límite infinito: asíntota vertical')
plt.legend()
plt.grid(True)
plt.show()

# 4. Discontinuidad de salto (función por partes)
def salto(x):
    return np.where(x < 2, 1, 3)

x4 = np.linspace(0, 4, 500)
y4 = salto(x4)
plt.figure(figsize=(6,4))
plt.plot(x4, y4, 'm-', linewidth=2, label='f(x)')
# Puntos en el salto
plt.plot(2, 1, 'ro', markersize=8, label='(2,1) izquierdo')
plt.plot(2, 3, 'bo', markersize=8, fillstyle='none', label='(2,3) derecho')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Discontinuidad de salto')
plt.legend()
plt.grid(True)
plt.show()

# 5. Discontinuidad removible (hueco) con función simplificada x+1
x5 = np.linspace(0, 3, 200)
y5 = x5 + 1
plt.figure(figsize=(6,4))
plt.plot(x5, y5, 'orange', linewidth=2, label='f(x)=x+1 (excepto en x=1)')
plt.plot(1, 2, 'wo', markeredgecolor='red', markersize=10, label='Hueco en (1,2)')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Discontinuidad removible: límite = 2')
plt.legend()
plt.grid(True)
plt.show()

# 6. Teorema del Valor Intermedio: función continua que cruza y=25
x6 = np.linspace(1, 10, 200)
# Función cuadrática que pasa por (1,12) y (10,35) y tiene un mínimo
# Para que cruce 25, usamos una parábola: f(x)=a(x-5.5)^2 + b, ajustar
# Ajuste simple: f(1)=12, f(10)=35 -> resolvemos
# a(1-5.5)^2 + b = 12 -> a*20.25 + b =12
# a(10-5.5)^2 + b =35 -> a*20.25 + b =35 --> contradicción? No puede ser misma a.
# Mejor usar una recta y agregar una curvatura suave:
y6 = 12 + (35-12)/(10-1)*(x6-1) + 2*np.sin(x6)  # pequeña oscilación
plt.figure(figsize=(6,4))
plt.plot(x6, y6, 'teal', linewidth=2, label='f(x) continua')
plt.axhline(y=25, color='red', linestyle='--', label='y=25')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Teorema del Valor Intermedio: existe c tal que f(c)=25')
plt.legend()
plt.grid(True)
plt.show()
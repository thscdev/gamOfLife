# Installations Anleitung

Unter Ubuntu in der Idea IDE lässt sich das Terminal nicht flushen.

Es muss eine .jar erstellt werden:

1. Rechts unter maven -> Lifecycle -> install doppelt klicken.
2. Im Anschluss in den Ordner des Projektes navigieren. Dort findet sich im *target* Ordner die .jar
3. Mit **java -jar [GameOfLife...].jar** das Programm starten
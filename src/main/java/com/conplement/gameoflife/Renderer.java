package com.conplement.gameoflife;

import com.conplement.gameoflife.generation.OldGeneration;

public interface Renderer {

    void render(OldGeneration oldGeneration, int generationCounter);
}

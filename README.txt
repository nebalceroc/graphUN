# graphUN
CAD language analyzer

GraphUN is a CAD language designed to work with the processing library.

Language specifications:

1. The language uses nested tags (<tag> </tag>) to create graphics over a 2D canvas.
2. GraphUN have a "ligth" version, that is used to work using the graphUN CLI.
3. Nesting figures inside each other creates a structure of child- father coords.
4. Nesting figures inside properties tags, will override default figure properties.
5. To prevent override, a flag must be declared on the figure tag.

BASIC FIGURES:
- Circle.
- Sphere.
- Triangle.

BASIC PROPERTIES 
- size(according each figure).
- colors(fill, border).
- coords and coord type.

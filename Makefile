.PHONY : all clean

all : extensible_exception.pdf extensible_exception_without_animation.pdf

clean :
	latexmk -C

extensible_exception.pdf : 
	latexmk -pdf extensible_exception.tex

extensible_exception_without_animation.pdf : 
	latexmk -pdf extensible_exception_without_animation.tex

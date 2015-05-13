import java.awt.List;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class UNCADListenerC implements UNCADListener {
	
	UNCADParser parser;

	public UNCADListenerC(UNCADParser parser) {
		this.parser = parser;
	}
	
	@Override
	public void enterDoc(UNCADParser.DocContext ctx){
		
	}
	
	@Override
	public void exitDoc(UNCADParser.DocContext ctx){
		
	}
	
	@Override
	public void enterBody(UNCADParser.BodyContext ctx){
		
	}
	
	@Override
	public void exitBody(UNCADParser.BodyContext ctx){
		
	}
	 
	@Override
	public void enterP_tag(UNCADParser.P_tagContext ctx){
		
	}

	@Override
	public void exitP_tag(UNCADParser.P_tagContext ctx){
		
	}
	
	@Override
	public void enterO_tag(UNCADParser.O_tagContext ctx){
		
	}
	
	@Override
	public void exitO_tag(UNCADParser.O_tagContext ctx){
		
	}
	
	@Override
	public void enterProps(UNCADParser.PropsContext ctx){
		
	}
	
	@Override
	public void exitProps(UNCADParser.PropsContext ctx){
		
	}
	
	@Override
	public void enterColor(UNCADParser.ColorContext ctx){
		
	}
	
	@Override
	public void exitColor(UNCADParser.ColorContext ctx){
		
	}
	
	@Override
	public void enterNewLine(UNCADParser.NewLineContext ctx){
	
	}

	@Override
	public void exitNewLine(UNCADParser.NewLineContext ctx){
	}
	
	@Override
	public void enterEveryRule(ParserRuleContext ctx){
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx){
	}

	@Override
	public void visitErrorNode(ErrorNode node){
	}

	@Override
	public void visitTerminal(TerminalNode node){
	}

}
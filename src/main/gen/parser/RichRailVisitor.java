// Generated from /home/robert-jan/Git/RichRail/src/main/antlr/parser/RichRail.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RichRailParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RichRailVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RichRailParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(RichRailParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#newcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewcommand(RichRailParser.NewcommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#newtraincommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewtraincommand(RichRailParser.NewtraincommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#newwagoncommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#addcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddcommand(RichRailParser.AddcommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#getcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetcommand(RichRailParser.GetcommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#delcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelcommand(RichRailParser.DelcommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#remcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemcommand(RichRailParser.RemcommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RichRailParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(RichRailParser.TypeContext ctx);
}
module ch.rweiss.terminal.nativ
{
  exports ch.rweiss.terminal.windows;
  exports ch.rweiss.terminal.linux;
  
  requires transitive com.sun.jna;
  requires com.sun.jna.platform;
}
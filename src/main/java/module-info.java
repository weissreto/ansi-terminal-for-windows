module ch.rweiss.terminal.nativ
{
  exports ch.rweiss.terminal.nativ;
  exports ch.rweiss.terminal.nativ.windows;
  exports ch.rweiss.terminal.nativ.linux;
  exports ch.rweiss.bitset;
  
  requires transitive com.sun.jna;
  requires com.sun.jna.platform;
}
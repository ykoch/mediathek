package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    private Vormerkkarte _vormerkkarte;
    private Kunde _vormerker1;
    private Kunde _vormerker2;
    private Kunde _vormerker3;
    private Medium _medium;

    public VormerkkarteTest()
    {
        _vormerker1 = new Kunde(new Kundennummer(123456), "ich", "du");
        _vormerker2 = new Kunde(new Kundennummer(123457), "er", "sie");
        _vormerker3 = new Kunde(new Kundennummer(123458), "es", "wir");

        _medium = new CD("bar", "baz", "foo", 123);
        _vormerkkarte = new Vormerkkarte(_vormerker1, _medium);
    }

    @Test
    public void testeVormerkungeHinzugefuegt()
    {
        assertTrue(_vormerkkarte.getAlleVormerker()
            .size() == 1);
        _vormerkkarte.fuegeVormerkerHinzu(_vormerker1);
        assertTrue(_vormerkkarte.getAlleVormerker()
            .size() == 2);

    }

    @Test
    public void testeIstKarteVoll()
    {
        assertTrue(false == _vormerkkarte.istVormerkkarteVoll());

    }

}

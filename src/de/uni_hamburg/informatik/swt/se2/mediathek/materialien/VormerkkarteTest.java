package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

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
    public void testeKonstruktor() throws Exception
    {
        assertEquals(_vormerker1, _vormerkkarte.getErstenVormerker());

        List<Kunde> testArray = new LinkedList<Kunde>();
        testArray.add(_vormerker1);
        assertEquals(testArray, _vormerkkarte.getAlleVormerker());
        assertEquals(_medium, _vormerkkarte.getMedium());
    }

    @Test
    public void testeVormerkungHinzugefuegt()
    {
        assertTrue(_vormerkkarte.getAlleVormerker()
            .size() == 1);
        _vormerkkarte.fuegeVormerkerHinzu(_vormerker2);
        assertTrue(_vormerkkarte.getAlleVormerker()
            .size() == 2);
    }

    @Test
    public void testeVormerkerAnPosition()
    {
        assertEquals(_vormerker1, _vormerkkarte.getVormerkerAnPosition(0));
        _vormerkkarte.fuegeVormerkerHinzu(_vormerker2);
        assertEquals(_vormerker2, _vormerkkarte.getVormerkerAnPosition(1));
    }

    @Test
    public void testeGetMedium()
    {
        assertEquals(_medium, _vormerkkarte.getMedium());
    }

    @Test
    public void testeIstKarteVoll()
    {
        assertTrue(false == _vormerkkarte.istVormerkkarteVoll());

    }

    @Test
    public void testeEntferneVormerker()
    {
        _vormerkkarte.fuegeVormerkerHinzu(_vormerker2);
        _vormerkkarte.entferneVormerker(_vormerker2);
        assertTrue(1 == _vormerkkarte.getAlleVormerker()
            .size());
    }

    @Test
    public void testegetFormatiertenString() throws Exception
    {
        assertNotNull(_vormerkkarte.getFormatiertenString());
    }

    @Test
    public void testEquals()
    {
        Vormerkkarte karte1 = new Vormerkkarte(_vormerker1, _medium);

        assertTrue(_vormerkkarte.equals(karte1));
        assertEquals(_vormerkkarte.hashCode(), karte1.hashCode());

        Kunde vormerker4 = new Kunde(new Kundennummer(654321), "ich", "du");
        CD medium2 = new CD("hallo", "welt", "foo", 321);
        Vormerkkarte karte2 = new Vormerkkarte(vormerker4, medium2);

        assertFalse(_vormerkkarte.equals(karte2));
        assertNotSame(_vormerkkarte.hashCode(), karte2.hashCode());

    }

}

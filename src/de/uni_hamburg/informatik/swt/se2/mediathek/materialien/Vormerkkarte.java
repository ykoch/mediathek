package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe von Vormerkkarten werden beim Vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde vorgemerkt? Wer
 * hat das Medium vorgemerkt? 
 * 
 * Wenn keine Vormerkungen mehr vorhanden sind, kann die zugehörige Vormerkkarte entsorgt
 * werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author KESS Faktor 1
 * @version SoSe 2019
 */
public class Vormerkkarte
{

    // Eigenschaften einer Verleihkarte
    private final Medium _medium;
    private List<Kunde> _vormerkerliste;

    /**
     * Initialisert eine neue Vormerkkarte mit den gegebenen Daten.
     * 
     * @param vormerker Ein Kunde, der das Medium ausgeliehen hat.
     * @param medium Ein verliehene Medium.
     * @param vormerkliste Ein Array, das alle Vormerker beinhaltet
     * 
     * @require vormerker != null
     * @require medium != null
     * @require vormerkliste != null
     * 
     * @ensure #getVormerker() == vormerker
     * @ensure #getMedium() == medium
     * @ensure #getVormerkliste() == vormerkliste
     */
    public Vormerkkarte(Kunde vormerker, Medium medium)
    {
        assert vormerker != null : "Vorbedingung verletzt: entleiher != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";

        _medium = medium;
        _vormerkerliste = new LinkedList<Kunde>();
        _vormerkerliste.add(vormerker);
    }

    /**
     * Gibt den ersten Vormerker zurück. Es kann auch keinen Vormerker geben. 
     * 
     * @return den ersten Kunden, der das Medium vorgemerkt hat.
     * 
     * @ensure result != null
     */
    public Kunde getErstenVormerker()
    {
        return _vormerkerliste.get(0);
    }

    /**
     * Gibt Liste der Vormerker zurück. Kann 0 bis 3 Vormerker sein. 
     * 
     * @return Liste der Kunden, die das Medium vorgemerkt hat.
     * 
     * @ensure result != null
     */
    public List<Kunde> getAlleVormerker()
    {
        return _vormerkerliste;
    }

    /**
     * Gibt den Vormerker an der Indexposition zurück
     * 
     * @param Index des Vormerkerarrays
     * @return Den Kunden, der das Medium vorgemerkt hat
     * 
     * @ensure result != null
     */
    public Kunde getVormerkerAnPosition(int index)
    {
        return _vormerkerliste.get(index);
    }

    /**
     * Gibt das Medium, dessen Ausleihe auf der Karte vorgemerkt ist, zurück.
     * 
     * @return Das Medium, dessen Vormerkung auf dieser Karte vermerkt ist.
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }

    /**
     * Gibt zurück, ob die Vormerkkarte voll ist, das heißt, ob es bereits 3 Vormerker für das Medium gibt
     * 
     * @return ob die Vormerkkarte voll ist
     * @ensure result != null
     */
    public boolean istVormerkkarteVoll()
    {
        return (_vormerkerliste.size() == 3);
    }

    /**
     * Entfernt einen Kunden von der Vormerkkarte
     * 
     * @param den zu entfernende Kunde
     * 
     * @ensure result != null
     */
    public void entferneVormerker(Kunde vormerker)
    {
        _vormerkerliste.remove(vormerker);
    }

    /**
     * Fügt einen Kunden zu der Vormerkkarte hinzu
     * 
     * @param den hinzuzufügende Kunde
     * 
     * @ensure result != null
     */
    public void fuegeVormerkerHinzu(Kunde vormerker)
    {
        if (!istVormerkkarteVoll())
        {
            _vormerkerliste.add(vormerker);
        }
    }

    /**
     * Gibt eine String-Darstellung der Vormerkkarte (enhält Zeilenumbrüche)
     * zurück.
     * 
     * @return Eine formatierte Stringrepäsentation der Vormerkkarte. Enthält
     *         Zeilenumbrüche.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        String vormerkersatz = "Keine Vormerkungen";
        for (Kunde vormerker : _vormerkerliste)
        {
            vormerkersatz = "";
            vormerkersatz = vormerkersatz + vormerker + " , ";
        }

        return _medium.getFormatiertenString() + " vorgemerkt an\n"
                + vormerkersatz;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((_vormerkerliste == null) ? 0 : _vormerkerliste.hashCode());
        result = prime * result + ((_medium == null) ? 0 : _medium.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj instanceof Verleihkarte)
        {
            Vormerkkarte other = (Vormerkkarte) obj;

            if (other.getAlleVormerker()
                .equals(_vormerkerliste)
                    && other.getMedium()
                        .equals(_medium))

                result = true;
        }
        return result;
    }
}

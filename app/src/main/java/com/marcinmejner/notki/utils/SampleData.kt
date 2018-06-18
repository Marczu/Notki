package com.marcinmejner.notki.utils

import com.marcinmejner.notki.model.NoteEntity
import java.util.*

class SampleData {

    companion object {

        const val SAMPLE_TEXT_1 = "Prosta notka"
        const val SAMPLE_TEXT_2 = "Prosta notka \n w nastepnej linii"
        const val SAMPLE_TEXT_3 = "Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. Został po raz pierwszy użyty w XV w. " +
                "przez nieznanego drukarza do wypełnienia tekstem próbnej książki. Pięć wieków później zaczął być używany przemyśle elektronicznym, pozostając praktycznie " +
                "niezmienionym. Spopularyzował się w latach 60. XX w. wraz z publikacją arkuszy Letrasetu, zawierających fragmenty Lorem Ipsum, a ostatnio z zawierającym różne " +
                "wersje Lorem Ipsum oprogramowaniem przeznaczonym do realizacji druków na komputerach osobistych, jak Aldus PageMaker"


        fun getDate(diff: Int): Date {
            val calendar = GregorianCalendar()
            calendar.add(Calendar.MILLISECOND, diff)

            return calendar.time
        }

        fun getNotes(): List<NoteEntity> {
            val notes = mutableListOf<NoteEntity>()

            notes.add(NoteEntity(getDate(0), SAMPLE_TEXT_1, 1))
            notes.add(NoteEntity(getDate(-1), SAMPLE_TEXT_2, 2))
            notes.add(NoteEntity(getDate(-2), SAMPLE_TEXT_3, 3))

            return notes
        }

    }

}
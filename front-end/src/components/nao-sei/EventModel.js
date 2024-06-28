// src/models/EventModel.js

import { useEffect, useState } from "react";
import EventsPattern from "../event-patterns/EventsPattern";
import axios from "axios";

export function useEventModel() {
  // const [eventos, setEventos] = useState(EventsPattern);
  const [EventoSelecionado, setEventoSelecionado] = useState(null);
  const [EventosFiltrados, setEventosFiltrados] = useState(EventsPattern);
  const [eventos, setEventos] = useState([])

  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get("http://localhost:8080/evento")
      console.log(response.data)
      setEventos(response.data)
    }
    fetchData()
  }, [])

  const onEventDrop = (data) => {
    const { start, end } = data;
    const updatedEvents = eventos.map((event) => {
      if (event.id === data.event.id) {
        return {
          ...event,
          start: new Date(start),
          end: new Date(end),
        };
      }
      return event;
    });
    setEventos(updatedEvents);
  };

  const handleAdicionar = (novoEvento) => {
    setEventos([...eventos, { ...novoEvento, id: eventos.length + 1 }]);
  };

  const handleEventDelete = (eventId) => {
    const updatedEvents = eventos.filter((event) => event.id !== eventId);
    setEventos(updatedEvents);
    setEventoSelecionado(null);
  };

  const handleEventUpdate = (updatedEvent) => {
    const updatedEvents = eventos.map((event) => {
      if (event.id === updatedEvent.id) {
        return updatedEvent;
      }
      return event;
    });
    setEventos(updatedEvents);
    setEventoSelecionado(null);
  };

  const handleSelecionarAtividades = (AtividadesSelecionadas) => {
    setEventosFiltrados(AtividadesSelecionadas);
  };

  return {
    Eventos: eventos,
    EventoSelecionado,
    EventosFiltrados,
    setEventoSelecionado,
    onEventDrop,
    handleAdicionar,
    handleEventDelete,
    handleEventUpdate,
    handleSelecionarAtividades,
  };
}

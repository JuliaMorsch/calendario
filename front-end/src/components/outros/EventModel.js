// src/models/EventModel.js

import { useEffect, useState } from "react";
import EventsPattern from "../event-patterns/EventsPattern";
import axios from "axios";

export function useEventModel() {
  const [EventoSelecionado, setEventoSelecionado] = useState(null);
  const [EventosFiltrados, setEventosFiltrados] = useState(EventsPattern);
  const [eventos, setEventos] = useState([])

  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get("http://localhost:8080/evento")
      console.log(response)
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

  const handleEventDelete = async (eventId) => {
    const updatedEvents = eventos.filter((event) => event.id !== eventId);
    const response = await axios.delete(`http://localhost:8080/evento/${eventId}`)
    console.log(response);
    setEventos(updatedEvents);
    setEventoSelecionado(null);
  };

  const handleEventUpdate = async (updatedEvent) => {

    const response = axios.put("http://localhost:8080/evento", updatedEvent)
    console.log(response)
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

import axios from "axios";

const state = {
    person: {
        name: '',
        diffculty: '',
        creditLevel: '',
        energyConsumption: '',
    },
    community: {
        name: '',
        diffculty: '',
        energyConsumption: '',
        rishLevel: '',
    },
    finance: {
        name: '',
        diffculty: '',
        creditLevel: '',
    },
    tripChart: {
        dataAxis: [],
        dataYaxis: [],
    },
    resourceChart: {
        dataAxis: [],
        dataYaxis: [],
    },
}

// getters
const getters = {
    
}

// actions
const actions = {
    getPerson({state, commit}, payload) {
        let {name} = payload
        axios.get(`/smartSociety/a?name=${name}`).then(res => {
            let {diffculty, creditLevel, energyConsumption} = res.data
            let person = {...state.person}
            person.diffculty = diffculty
            person.creditLevel = creditLevel
            person.energyConsumption = energyConsumption
            commit('setState', {
                person
            })
        })
    },

    getCommunity({state, commit}, payload) {
        let {name} = payload
        axios.get(`/smartSociety/b?name=${name}`).then(res => {
            let {diffculty, energyConsumption, rishLevel} = res.data
            let community = {...state.community}
            community.diffculty = diffculty
            community.energyConsumption = energyConsumption
            community.rishLevel = rishLevel
            commit('setState', {
                community
            })
        })
    },

    getFinance({state, commit}, payload) {
        let {name} = payload
        axios.get(`/smartSociety/c?name=${name}`).then(res => {
            let {diffculty, creditLevel} = res.data
            let finance = {...state.finance}
            finance.diffculty = diffculty
            finance.creditLevel = creditLevel
            commit('setState', {
                finance
            })
        })
    },

    getTripChart({state, commit}) {
        axios.get(`/smartSociety/d`).then(res => {
            let tripChart = {...state.tripChart}
            tripChart.dataAxis = JSON.parse(res.data.dataAxis)
            tripChart.dataYaxis = JSON.parse(res.data.dataYaxis)
            commit('setState', {
                tripChart
            })
        })
    },

    getResourceChart({state, commit}) {
        axios.get(`/smartSociety/e`).then(res => {
            let resourceChart = {...state.resourceChart}
            resourceChart.dataAxis = JSON.parse(res.data.dataAxis)
            resourceChart.dataYaxis = JSON.parse(res.data.dataYaxis)
            commit('setState', {
                resourceChart
            })
        })
    },

    
}

// mutations
const mutations = {
    setState (state, payload) {
        for (const key in payload) {
            if (payload.hasOwnProperty(key)) {
                state[key] = payload[key]
            }
        }
    },
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}

<template>
    <div>
        <div>
            <el-input
                class="name-input"
                placeholder="请输入姓名"
                v-model="stateHome.person.name"
                clearable>
            </el-input>
            <el-button type="primary" @click="appraise">评估</el-button>
        </div>
        <div class="fs14">
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户困难指数:</el-col>
                <el-col :span='2'>{{stateHome.person.diffculty}}</el-col>
                <el-col :span='10'>
                    <el-button type="mini" plain>社区帮助</el-button>
                </el-col>
            </el-row>
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户信用评级:</el-col>
                <el-col :span='2'>{{stateHome.person.creditLevel}}</el-col>
                <el-col :span='10'>
                    <el-button type="mini" plain>金融服务</el-button>
                </el-col>
            </el-row>
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户能源消耗类别:</el-col>
                <el-col :span='2' class="fs14">{{stateHome.person.energyConsumption}}</el-col>
                <el-col :span='10'>
                    <el-button type="mini" plain>缴费</el-button>
                    <el-button type="mini" plain>故障维修</el-button>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
export default {
    name: 'PersonTag',

    computed: mapState({
        stateHome: state => state.home
    }),

    data() {
        return {
            // personName: ''
        }
    },

    mounted() {
        
    },

    methods: {
        appraise() {
            this.$store.dispatch('home/getPerson', {name: this.stateHome.person.name})
        }
    },
}
</script>
<style lang="less" scoped>
    .name-input{
        width: 234px;
        margin-right: 16px;
    }

    .item-row{
        margin-top: 16px;
    }
</style>
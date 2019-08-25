<template>
    <div>
        <div>
            <el-input
                class="name-input"
                placeholder="请输入姓名"
                v-model="stateHome.finance.name"
                clearable>
            </el-input>
            <el-button type="primary" @click="appraise">评估</el-button>
        </div>
        <div class="fs14">
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户困难指数:</el-col>
                <el-col :span='2'>{{stateHome.finance.diffculty}}</el-col>
                <el-col :span='10'>
                    <el-button type="mini" plain>社区帮助</el-button>
                </el-col>
            </el-row>
            <el-row :span='24' class="item-row">
                <el-col :span='4'>该用户信用评级:</el-col>
                <el-col :span='2'>{{stateHome.finance.creditLevel}}</el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
export default {
    name: 'FinanceTag',

    computed: mapState({
        stateHome: state => state.home
    }),

    methods: {
        appraise() {
            this.$store.dispatch('home/getFinance', {name: this.stateHome.finance.name})
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
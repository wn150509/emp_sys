<template>
  <div>
    <el-dialog :title="isAdd ? '新增' : '编辑'" :visible.sync="dialog" @close="cancel">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="员工编号">
          <el-select v-model="form.empNo" filterable placeholder="请选择" @focus="queryEmpNo" @change="queryEmp">
            <el-option
              v-for="item in options"
              :key="item.empNo"
              :label="item.empNo"
              :value="item.empNo"
              :disabled="isAdd == false">
              <span style="float: left">{{ item.empNo }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">{{ item.empName }}</span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-row>
          <el-col :span="11">
            <el-form-item label="员工姓名" prop="empName">
              <el-input size="small" v-model="form.empName" placeholder="请输入员工姓名"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="岗位工资" prop="workSalery">
              <el-input size="small" v-model="form.workSalery" placeholder="请输入岗位工资"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="11">
            <el-form-item label="离岗扣除" prop="absent">
              <el-input size="small" v-model="form.absent" placeholder="请输入离岗扣除"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="福利数额" prop="allowance">
              <el-input size="small" v-model="form.allowance" placeholder="请输入福利"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="11">
            <el-form-item label="休假扣除" prop="vacation">
              <el-input size="small" v-model="form.vacation" placeholder="请输入休假扣除"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="奖金数额" prop="reward">
              <el-input size="small" v-model="form.reward" placeholder="请输入奖金"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button class="update-btn" type="primary" @click="doSubmit">提交</el-button>
        <el-button class="update-btn" @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { getByNo, getAllEmp} from "@/api/employee";
import { add, update } from "@/api/salery";
export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      form: {
        empNo: "",
        empName: "",
        workSalery: "",
        allowance: "",
        vacation: "",
        reward: "",
        absent: "",
        total: ""
      },
      dialog: false,
      options: []
    }
  },
  methods: {
    queryEmpNo(){
      getAllEmp().then(res =>{
        this.options = res
      })
    },
    queryEmp() {
      let that = this;
      getByNo(this.form.empNo).then(data => {
        that.form.empName = data.empName;
      });
    },
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.form = {
        empNo: "",
        empName: "",
        workSalery: "",
        allowance: "",
        vacation: "",
        reward: "",
        absent: "",
        total: ""
      };
    },
    doSubmit() {
      if (this.isAdd) {
        this.add();
      } else {
        this.update();
      }
    },
    add() {
      let that = this;
      add(this.form).then(data => {
          that.$notify({
            title: '成功',
            message: '添加成功',
            type: 'success'
          });
          that.reset();
          that.$parent.getData();
        }).catch(function(error) {
          console.log(error);
        });
    },
    update() {
      let that = this;
      update(this.form).then(data => {
          that.$notify({
            title: '成功',
            message: '修改成功',
            type: 'success'
          });
          that.$parent.getData();
          that.reset();
        }).catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>
